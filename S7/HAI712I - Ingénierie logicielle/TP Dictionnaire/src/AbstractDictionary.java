import java.util.List;

public abstract class AbstractDictionary implements IDictionary {
    protected Object[] keys;
    protected Object[] values;

    public AbstractDictionary() {
        this.keys = new Object[0];
        this.values = new Object[0];
    }

    public int size() {
        int cpt = 0;
        for(int i = 0; i < keys.length; i++) {
            if(keys[i] != null) cpt++;
        }
        return cpt;
    }

    public boolean isEmpty() {
        return keys.length == 0;
    }

    abstract protected int indexOf(Object key);
    abstract protected int newIndexOf(Object key);

    public Object get(Object key) throws Exception {
        int index = this.indexOf(key);
        if(index != -1) return this.values[index];
        else {
            throw new Exception("La clé " + key + " n'a pas été trouvée dans le dictionnaire");
        }
    }


    public IDictionary put(Object key, Object value) {
        int index = this.indexOf(key);
        if(index == -1) {
            index = this.newIndexOf(key);
        }
        keys[index] = key;
        values[index] = value;
        return this;
    }


}
