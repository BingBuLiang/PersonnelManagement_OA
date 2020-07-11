package com.hu.entity;

/**
 * @author 胡冰
 * @version 1.0
 * @create 2020-06-09 7:34
 * @decription
 **/

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 员工类
 */
public class Employee implements Serializable {
    /**
     * 员工编号
     */
    private String empId;
    /**
     * 密码
     */
    private String password;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 性别
     */
    private String sex;
    /**
     * 出生日期
     */
    private Date birthDate;
    /**
     * 入职日期
     */
    private Date hireDate;
    /**
     * 离职日期
     */
    private Date leaveDate;
    /**
     * 是否在职  0-离职  1-在职
     */
    private int onDuty;
    /**
     * 员工类型  1.普通员工  2.管理人员 含经理、总监、总裁等  3.管理员
     */
    private int empType;
    /**
     * 联系方式
     */
    private String phone;

    private String qq;
    /**
     * 紧急联系人信息
     */
    private String emerContactPerson;
    /**
     * 身份证号码
     */
    private String idCard;
    /**
     * 员工所属部门  不仅包含部门的编号，还包含其他信息
     */
    private Department dept;

    private Position position;
    /**
     * 上级领导的信息
     */
    private Employee mgr;
    /**
     * 下级的信息，可能多个
     */
    private List<Employee> empList = new ArrayList<Employee>();


    public Employee() {
        super();
    }


    public Employee(String empId, String password, String realName, String sex,
                    Date birthDate, Date hireDate, Date leaveDate, int onDuty,
                    int empType, String phone, String qq, String emerContactPerson,
                    String idCard, Department dept, Position position, Employee mgr) {
        super();
        this.empId = empId;
        this.password = password;
        this.realName = realName;
        this.sex = sex;
        this.birthDate = birthDate;
        this.hireDate = hireDate;
        this.leaveDate = leaveDate;
        this.onDuty = onDuty;
        this.empType = empType;
        this.phone = phone;
        this.qq = qq;
        this.emerContactPerson = emerContactPerson;
        this.idCard = idCard;
        this.dept = dept;
        this.position = position;
        this.mgr = mgr;
    }


    public Employee(String empId, String password, String realName, String sex,
                    Date birthDate, Date hireDate, Date leaveDate, int onDuty,
                    int empType, String phone, String qq, String emerContactPerson,
                    String idCard, Department dept, Position position, Employee mgr,
                    List<Employee> empList) {
        super();
        this.empId = empId;
        this.password = password;
        this.realName = realName;
        this.sex = sex;
        this.birthDate = birthDate;
        this.hireDate = hireDate;
        this.leaveDate = leaveDate;
        this.onDuty = onDuty;
        this.empType = empType;
        this.phone = phone;
        this.qq = qq;
        this.emerContactPerson = emerContactPerson;
        this.idCard = idCard;
        this.dept = dept;
        this.position = position;
        this.mgr = mgr;
        this.empList = empList;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Date getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
    }

    public int getOnDuty() {
        return onDuty;
    }

    public void setOnDuty(int onDuty) {
        this.onDuty = onDuty;
    }

    public int getEmpType() {
        return empType;
    }

    public void setEmpType(int empType) {
        this.empType = empType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmerContactPerson() {
        return emerContactPerson;
    }

    public void setEmerContactPerson(String emerContactPerson) {
        this.emerContactPerson = emerContactPerson;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Employee getMgr() {
        return mgr;
    }

    public void setMgr(Employee mgr) {
        this.mgr = mgr;
    }

    public List<Employee> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Employee> empList) {
        this.empList = empList;
    }


    @Override
    public String toString() {
        return "Employee [empId=" + empId + ", password=" + password
                + ", realName=" + realName + ", sex=" + sex + ", birthDate="
                + birthDate + ", hireDate=" + hireDate + ", leaveDate="
                + leaveDate + ", onDuty=" + onDuty + ", empType=" + empType
                + ", phone=" + phone + ", qq=" + qq + ", emerContactPerson="
                + emerContactPerson + ", idCard=" + idCard + ", dept=" + dept
                + ", position=" + position + ", mgr=" + mgr + ", empList="
                + empList + "]";
    }
}
