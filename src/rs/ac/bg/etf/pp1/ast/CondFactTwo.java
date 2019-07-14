// generated with ast extension for cup
// version 0.8
// 21/5/2019 17:55:39


package rs.ac.bg.etf.pp1.ast;

public class CondFactTwo extends CondFact {

    private NtCondFact NtCondFact;

    public CondFactTwo (NtCondFact NtCondFact) {
        this.NtCondFact=NtCondFact;
        if(NtCondFact!=null) NtCondFact.setParent(this);
    }

    public NtCondFact getNtCondFact() {
        return NtCondFact;
    }

    public void setNtCondFact(NtCondFact NtCondFact) {
        this.NtCondFact=NtCondFact;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(NtCondFact!=null) NtCondFact.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(NtCondFact!=null) NtCondFact.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(NtCondFact!=null) NtCondFact.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CondFactTwo(\n");

        if(NtCondFact!=null)
            buffer.append(NtCondFact.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CondFactTwo]");
        return buffer.toString();
    }
}
