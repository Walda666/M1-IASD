public class OrdererDictionary extends AbstractDictionary {

    public OrdererDictionary() {
        super();
    }

    @Override
    protected int indexOf(Object key) {
        boolean found = false;
        int i = 0;
        while (!found && i < keys.length) {
            if (keys[i].equals(key)) {
                found = true;
            } else {
                i++;
            }
        }
        return found ? i : -1;
    }

    @Override
    protected int newIndexOf(Object key) {
        int i = keys.length;
        Object[] newKeys = new Object[i + 1];
        Object[] newValues = new Object[i + 1];
        for (int j = 0; j < i; j++) {
            newKeys[j] = keys[j];
            newValues[j] = values[j];
        }
        keys = newKeys;
        values = newValues;

        return i;
    }
}
