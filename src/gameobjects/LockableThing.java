/*
 * Sample Java file by Huw Collingbourne
 *
 * This code (and other sample code) accompanies the book
 *    "The Little Book of Adventure Game Programming In Java"
 * Source code can be downloaded from:
 *     http://www.bitwisebooks.com
 */
package gameobjects;

public class LockableThing extends ContainerThing implements java.io.Serializable {

    private boolean locked;
    private Thing thingToUnlockWith; // e.g. a specific key

    public LockableThing(String aName, String aDescription, int aMass, boolean isLocked) {
        super(aName, aDescription, aMass);
        locked = isLocked;
        thingToUnlockWith = null;
    }

    public LockableThing(String aName, String aDescription, int aMass,
            boolean canTake, boolean canMove, boolean canOpen, boolean isOpen,
            boolean isLocked) {
        super(aName, aDescription, aMass, canTake, canMove, canOpen, isOpen);
        locked = isLocked;
        thingToUnlockWith = null;
    }

    // This is the thing (e.g. a key) that can unlock this LockableThing
    public void canBeUnlockedWith(Thing t) {
        thingToUnlockWith = t;
    }

    public String trytounlockWith(Thing t) {
        String s;

        if (!locked) {
            // s = getDescription() + " is already unlocked";
            s = getDescription() + " já está destrancado(a)";
        } else if (t == thingToUnlockWith) {
            locked = false;
            // s = "You unlock the " + this.getDescription() + " with the " + t.getDescription();
            s = "Você destrancou o " + this.getDescription() + " com " + t.getDescription();
      
        } else {
            // s = "You can't unlock the " + this.getDescription() + " with the " + t.getDescription();
            s = "Não é possível destrancar o " + this.getDescription() + " com " + t.getDescription();
        }
        return s;
    }

    public String trytolockWith(Thing t) {
        String s;

        if (locked) {
            s = "The " + getDescription() + " is already locked.";
        } else if (isOpen()) {
            s = "You cannot lock the " + getDescription() + " while it is open.";
        } else if (t == thingToUnlockWith) {
            locked = true;
            s = "You lock the " + getDescription();
        } else {
            s = "You can't lock the " + this.getDescription() + " with the " + t.getDescription();
        }
        return s;
    }

    @Override
    public String open() {
        String s;

        if (locked) {
            // s = "You can't open the " + getDescription() + " because it's locked.";
            s = "Não dá para abrir " + article(this.getName()) + " " + getDescription() + " porque está trancad" +article(this.getName())+ ".";
        } else {
            s = super.open();
        }
        return s;
    }

}
