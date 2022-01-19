package com.polaris.common.demo.designModel.IteratorDesign;

import java.util.Collection;

public class CollectionIteratorContainer implements IteratorContainer {
    @Override
    public Iterator getIterator(Collection collection) {
        return new IteratorTemplate(collection);
    }

    private static class IteratorTemplate implements Iterator {

        private Collection collection;

        int index;

        IteratorTemplate(Collection collection) {
            this.collection = collection;
        }

        @Override
        public boolean hasNext() {
            if (index < collection.size()) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return this.collection.toArray()[index++];
            }
            return null;
        }
    }
}
