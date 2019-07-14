// generated with ast extension for cup
// version 0.8
// 29/0/2019 15:45:33


package rs.ac.bg.etf.pp1.ast;

public class ActuralParamError extends ActualPars {

    public ActuralParamError () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ActuralParamError(\n");

        buffer.append(tab);
        buffer.append(") [ActuralParamError]");
        return buffer.toString();
    }
}
