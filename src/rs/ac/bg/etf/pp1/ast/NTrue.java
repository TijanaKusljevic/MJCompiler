// generated with ast extension for cup
// version 0.8
// 21/5/2019 17:55:39


package rs.ac.bg.etf.pp1.ast;

public class NTrue extends Factor {

    private NtTrue NtTrue;

    public NTrue (NtTrue NtTrue) {
        this.NtTrue=NtTrue;
        if(NtTrue!=null) NtTrue.setParent(this);
    }

    public NtTrue getNtTrue() {
        return NtTrue;
    }

    public void setNtTrue(NtTrue NtTrue) {
        this.NtTrue=NtTrue;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(NtTrue!=null) NtTrue.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(NtTrue!=null) NtTrue.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(NtTrue!=null) NtTrue.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NTrue(\n");

        if(NtTrue!=null)
            buffer.append(NtTrue.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NTrue]");
        return buffer.toString();
    }
}
