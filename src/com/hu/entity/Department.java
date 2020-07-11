package com.hu.entity;

import java.io.Serializable;

/**
 * @author 胡冰
 * @version 1.0
 * @create 2020-06-09 8:07
 * @decription 部门类
 **/

public class Department implements Serializable, Comparable<Department> {
    /**
     * 部门编号
     */
    private int deptno;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 所在地点
     */
    private String location;


    public Department() {
        super();
    }

    public Department(int deptno, String deptName) {

        this.deptno = deptno;
        this.deptName = deptName;
    }

    public Department(int deptno, String deptName, String location) {
        super();
        this.deptno = deptno;
        this.deptName = deptName;
        this.location = location;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getDeptno() {
        return deptno;
    }

    public String getDeptName() {
        return deptName;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Department [deptno=" + deptno + ", deptName=" + deptName
                + ", location=" + location + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((deptName == null) ? 0 : deptName.hashCode());
        result = prime * result + deptno;
        result = prime * result
                + ((location == null) ? 0 : location.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Department other = (Department) obj;
        if (deptName == null) {
            if (other.deptName != null) {
                return false;
            }
        } else if (!deptName.equals(other.deptName)) {
            return false;
        }
        if (deptno != other.deptno) {
            return false;
        }
        if (location == null) {
            if (other.location != null)
                return false;
        } else if (!location.equals(other.location))
            return false;
        return true;
    }

    @Override
    public int compareTo(Department other) {
        return this.deptno - other.deptno;
    }

}
