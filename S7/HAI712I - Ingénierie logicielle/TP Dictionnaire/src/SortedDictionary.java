public class SortedDictionary extends AbstractDictionary {

    public SortedDictionary() {
        super();
        this.keys = new Object[0];
        this.values = new Object[0];
    }


    public int compare(Object key1, Object key2) {
        Comparable<Object> comparableKey1 = (Comparable<Object>) key1;
        Comparable<Object> comparableKey2 = (Comparable<Object>) key2;
        return comparableKey1.compareTo(comparableKey2);
    }

    @Override
    protected int newIndexOf(Object key) {
        if (keys.length == 0) {
            keys = new Object[1];
            values = new Object[1];
            return 0;
        } else {
            for (int i = 0; i < keys.length; i++) {
                // Si plus petit en ordre alphabétique : on déplace toutes les clés de 1 pour pouvoir insérer à cet endroit
                if (compare(key, keys[i]) < 0) {
                    Object[] newKeys = new Object[keys.length + 1];
                    Object[] newValues = new Object[values.length + 1];
                    // Insère 0 -> i - 1
                    for (int j = 0; j < i; j++) {
                        newKeys[j] = keys[j];
                        newValues[j] = values[j];
                    }
                    // Insère i -> la fin
                    for (int j = i; j < keys.length; j++) {
                        newKeys[j + 1] = keys[j];
                        newValues[j + 1] = values[j];
                    }
                    keys = newKeys;
                    values = newValues;
                    return i;
                }
            }
        }
        System.out.println("Insertion à la fin");
        // Si plus grand en ordre alphabétique : on insère à la fin
        Object[] newKeys = new Object[keys.length + 1];
        Object[] newValues = new Object[values.length + 1];
        for(int i = 0; i < keys.length; i++) {
            newKeys[i] = keys[i];
            newValues[i] = values[i];
        }
        keys = newKeys;
        values = newValues;
        return keys.length-1;
    }

    @Override
    protected int indexOf(Object key) {
        /* Soit recherche séquentielle : on utilise compare == 0 (égalité)

        for(int i = 0; i < keys.length; i++) {
            if(keys[i] == null) return -1;
            if(compare(key, keys[i]) == 0) {
                return i;
            }
        }
        return -1;
         */

        // soit recherche dichotomique : on utilise compare == -1 ou 1 (inférieur ou supérieur)

        // Définition des bornes
        int min = 0;
        int max = keys.length - 1;
        int mid = (min + max) / 2;
        while (min <= max) { // Tant que les bornes ne se sont pas croisées : on change min et max selon le résultat de la comparaison
            if (compare(key, keys[mid]) == 0) {
                return mid;
            } else if (compare(key, keys[mid]) < 0) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
            mid = (min + max) / 2;
        }
        return -1;
    }
}
