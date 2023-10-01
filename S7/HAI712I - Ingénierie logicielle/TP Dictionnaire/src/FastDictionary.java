public class FastDictionary extends AbstractDictionary {

    public FastDictionary() {
        super();
    }


    protected boolean mustGrow() {
        if(keys.length == 0) return true;
        else {
            int proportion = size() / keys.length * 100; // % de remplissage du tableau
            return proportion > 75;
        }
    }
    protected void grow() {
        int i = keys.length;
        Object[] newKeys = new Object[i + 10];
        Object[] newValues = new Object[i + 10];
        for (int j = 0; j < i; j++) {
            newKeys[j] = keys[j];
            newValues[j] = values[j];
        }
        keys = newKeys;
        values = newValues;
    }

    @Override
    protected int indexOf(Object key) {
        if(mustGrow()) grow(); // Augmente le tableau si trop petit
        boolean found = false;
        int i = key.hashCode() % keys.length;
        if(i < 0) i += keys.length; // gère les hash négatifs
        // Même boucle for que dans OrderedDico mais en commencant à l'index hashed
        while (!found && i < keys.length) {
            if(keys[i] != null) {
            if (keys[i].equals(key)) {
                found = true;
            } else {
                i++;
            }
            } else {
                i++;
            }
        }
        return found ? i : -1;
    }

    @Override
    protected int newIndexOf(Object key) {
        if(mustGrow()) grow(); // Augmente le tableau si trop petit
        int hashed = key.hashCode() % keys.length;
        if (hashed < 0) hashed += keys.length;
        // Si case vide, on la retourne
        if (keys[hashed] == null) {
            return hashed;
        } else {
            // Sinon, on cherche la prochaine case vide
            for (int j = hashed; j < keys.length; j++) {
                if (keys[j] == null) {
                    return j;
                }
            }
        }
        // Si dictionnaire plein : erreur
        return -1;
    }

}
