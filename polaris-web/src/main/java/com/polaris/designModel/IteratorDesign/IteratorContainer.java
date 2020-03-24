package com.polaris.designModel.IteratorDesign;

import java.util.Collection;

public interface IteratorContainer<T> {
    Iterator getIterator(Collection<T> collection);
}
