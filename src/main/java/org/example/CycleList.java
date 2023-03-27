package org.example;

import java.util.ArrayList;
import java.util.List;

public final class CycleList<T> {
    private List<T> list;

    public CycleList() {
        list = new ArrayList<>();
    }

    public CycleList(List<T> list) {
        this.list = new ArrayList<>(list.size());
        this.list.addAll(list);

    }

    public T get(int index) {
        return list.get((index + list.size()) % list.size());
    }

    public CycleList<T> moveBy(int n) {
        List<T> newList = new ArrayList<>(list.size());
        for (int i = 0; i < list.size(); i++) {
            newList.add(get(i + n + list.size()));
        }
        return new CycleList<>(newList);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CycleList) || list.size() != ((CycleList<?>) obj).list.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equals(((CycleList<?>) obj).list.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (T item : list) {
            sb.append(item);
            sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public int size() {
        return list.size();
    }
}
