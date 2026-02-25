package org.irilo.poointerfaces.modelo;

import java.util.Objects;

public class BaseEntity {
    protected Integer id;
    private static int ultimoId;

    public BaseEntity() {
        this.id = ++ultimoId;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity that = (BaseEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
