// generated with ast extension for cup
// version 0.8
// 21/5/2019 17:55:38


package rs.ac.bg.etf.pp1.ast;

public class EnumDecl extends VarDeclaration {

    private EnumName EnumName;
    private FirstEnum FirstEnum;
    private EnumList EnumList;

    public EnumDecl (EnumName EnumName, FirstEnum FirstEnum, EnumList EnumList) {
        this.EnumName=EnumName;
        if(EnumName!=null) EnumName.setParent(this);
        this.FirstEnum=FirstEnum;
        if(FirstEnum!=null) FirstEnum.setParent(this);
        this.EnumList=EnumList;
        if(EnumList!=null) EnumList.setParent(this);
    }

    public EnumName getEnumName() {
        return EnumName;
    }

    public void setEnumName(EnumName EnumName) {
        this.EnumName=EnumName;
    }

    public FirstEnum getFirstEnum() {
        return FirstEnum;
    }

    public void setFirstEnum(FirstEnum FirstEnum) {
        this.FirstEnum=FirstEnum;
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
        if(EnumName!=null) EnumName.accept(visitor);
        if(FirstEnum!=null) FirstEnum.accept(visitor);
        if(EnumList!=null) EnumList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(EnumName!=null) EnumName.traverseTopDown(visitor);
        if(FirstEnum!=null) FirstEnum.traverseTopDown(visitor);
        if(EnumList!=null) EnumList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(EnumName!=null) EnumName.traverseBottomUp(visitor);
        if(FirstEnum!=null) FirstEnum.traverseBottomUp(visitor);
        if(EnumList!=null) EnumList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("EnumDecl(\n");

        if(EnumName!=null)
            buffer.append(EnumName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FirstEnum!=null)
            buffer.append(FirstEnum.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(EnumList!=null)
            buffer.append(EnumList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [EnumDecl]");
        return buffer.toString();
    }
}
