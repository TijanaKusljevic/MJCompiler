// generated with ast extension for cup
// version 0.8
// 21/5/2019 17:55:38


package rs.ac.bg.etf.pp1.ast;

public class EnumiNovo extends VarDeclaration {

    private EnumName EnumName;
    private String pr;
    private String dr;

    public EnumiNovo (EnumName EnumName, String pr, String dr) {
        this.EnumName=EnumName;
        if(EnumName!=null) EnumName.setParent(this);
        this.pr=pr;
        this.dr=dr;
    }

    public EnumName getEnumName() {
        return EnumName;
    }

    public void setEnumName(EnumName EnumName) {
        this.EnumName=EnumName;
    }

    public String getPr() {
        return pr;
    }

    public void setPr(String pr) {
        this.pr=pr;
    }

    public String getDr() {
        return dr;
    }

    public void setDr(String dr) {
        this.dr=dr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(EnumName!=null) EnumName.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(EnumName!=null) EnumName.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(EnumName!=null) EnumName.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("EnumiNovo(\n");

        if(EnumName!=null)
            buffer.append(EnumName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+pr);
        buffer.append("\n");

        buffer.append(" "+tab+dr);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [EnumiNovo]");
        return buffer.toString();
    }
}
