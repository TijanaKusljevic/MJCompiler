// generated with ast extension for cup
// version 0.8
// 31/0/2019 13:43:39


package rs.ac.bg.etf.pp1.ast;

public class EnumListDerived1 extends EnumList {

    private String optValue;
    private EnumList EnumList;

    public EnumListDerived1 (String optValue, EnumList EnumList) {
        this.optValue=optValue;
        this.EnumList=EnumList;
        if(EnumList!=null) EnumList.setParent(this);
    }

    public String getOptValue() {
        return optValue;
    }

    public void setOptValue(String optValue) {
        this.optValue=optValue;
    }

    public EnumList getEnumList() {
        return EnumList;
    }

    public void setEnumList(EnumList EnumList) {
        this.EnumList=EnumList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(EnumList!=null) EnumList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(EnumList!=null) EnumList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(EnumList!=null) EnumList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("EnumListDerived1(\n");

        buffer.append(" "+tab+optValue);
        buffer.append("\n");

        if(EnumList!=null)
            buffer.append(EnumList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [EnumListDerived1]");
        return buffer.toString();
    }
}
