// generated with ast extension for cup
// version 0.8
// 21/5/2019 17:55:39


package rs.ac.bg.etf.pp1.ast;

public class For extends Matched {

    private ChangeFor ChangeFor;
    private DesignatorStatementFor DesignatorStatementFor;
    private ConditionForStart ConditionForStart;
    private ConditionFor ConditionFor;
    private EndCF EndCF;
    private ForStatementStart ForStatementStart;
    private DesignatorStatementFor DesignatorStatementFor1;
    private ForStatementEnd ForStatementEnd;
    private ForStart ForStart;
    private Matched Matched;
    private ForEnd ForEnd;
    private GetOut GetOut;

    public For (ChangeFor ChangeFor, DesignatorStatementFor DesignatorStatementFor, ConditionForStart ConditionForStart, ConditionFor ConditionFor, EndCF EndCF, ForStatementStart ForStatementStart, DesignatorStatementFor DesignatorStatementFor1, ForStatementEnd ForStatementEnd, ForStart ForStart, Matched Matched, ForEnd ForEnd, GetOut GetOut) {
        this.ChangeFor=ChangeFor;
        if(ChangeFor!=null) ChangeFor.setParent(this);
        this.DesignatorStatementFor=DesignatorStatementFor;
        if(DesignatorStatementFor!=null) DesignatorStatementFor.setParent(this);
        this.ConditionForStart=ConditionForStart;
        if(ConditionForStart!=null) ConditionForStart.setParent(this);
        this.ConditionFor=ConditionFor;
        if(ConditionFor!=null) ConditionFor.setParent(this);
        this.EndCF=EndCF;
        if(EndCF!=null) EndCF.setParent(this);
        this.ForStatementStart=ForStatementStart;
        if(ForStatementStart!=null) ForStatementStart.setParent(this);
        this.DesignatorStatementFor1=DesignatorStatementFor1;
        if(DesignatorStatementFor1!=null) DesignatorStatementFor1.setParent(this);
        this.ForStatementEnd=ForStatementEnd;
        if(ForStatementEnd!=null) ForStatementEnd.setParent(this);
        this.ForStart=ForStart;
        if(ForStart!=null) ForStart.setParent(this);
        this.Matched=Matched;
        if(Matched!=null) Matched.setParent(this);
        this.ForEnd=ForEnd;
        if(ForEnd!=null) ForEnd.setParent(this);
        this.GetOut=GetOut;
        if(GetOut!=null) GetOut.setParent(this);
    }

    public ChangeFor getChangeFor() {
        return ChangeFor;
    }

    public void setChangeFor(ChangeFor ChangeFor) {
        this.ChangeFor=ChangeFor;
    }

    public DesignatorStatementFor getDesignatorStatementFor() {
        return DesignatorStatementFor;
    }

    public void setDesignatorStatementFor(DesignatorStatementFor DesignatorStatementFor) {
        this.DesignatorStatementFor=DesignatorStatementFor;
    }

    public ConditionForStart getConditionForStart() {
        return ConditionForStart;
    }

    public void setConditionForStart(ConditionForStart ConditionForStart) {
        this.ConditionForStart=ConditionForStart;
    }

    public ConditionFor getConditionFor() {
        return ConditionFor;
    }

    public void setConditionFor(ConditionFor ConditionFor) {
        this.ConditionFor=ConditionFor;
    }

    public EndCF getEndCF() {
        return EndCF;
    }

    public void setEndCF(EndCF EndCF) {
        this.EndCF=EndCF;
    }

    public ForStatementStart getForStatementStart() {
        return ForStatementStart;
    }

    public void setForStatementStart(ForStatementStart ForStatementStart) {
        this.ForStatementStart=ForStatementStart;
    }

    public DesignatorStatementFor getDesignatorStatementFor1() {
        return DesignatorStatementFor1;
    }

    public void setDesignatorStatementFor1(DesignatorStatementFor DesignatorStatementFor1) {
        this.DesignatorStatementFor1=DesignatorStatementFor1;
    }

    public ForStatementEnd getForStatementEnd() {
        return ForStatementEnd;
    }

    public void setForStatementEnd(ForStatementEnd ForStatementEnd) {
        this.ForStatementEnd=ForStatementEnd;
    }

    public ForStart getForStart() {
        return ForStart;
    }

    public void setForStart(ForStart ForStart) {
        this.ForStart=ForStart;
    }

    public Matched getMatched() {
        return Matched;
    }

    public void setMatched(Matched Matched) {
        this.Matched=Matched;
    }

    public ForEnd getForEnd() {
        return ForEnd;
    }

    public void setForEnd(ForEnd ForEnd) {
        this.ForEnd=ForEnd;
    }

    public GetOut getGetOut() {
        return GetOut;
    }

    public void setGetOut(GetOut GetOut) {
        this.GetOut=GetOut;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ChangeFor!=null) ChangeFor.accept(visitor);
        if(DesignatorStatementFor!=null) DesignatorStatementFor.accept(visitor);
        if(ConditionForStart!=null) ConditionForStart.accept(visitor);
        if(ConditionFor!=null) ConditionFor.accept(visitor);
        if(EndCF!=null) EndCF.accept(visitor);
        if(ForStatementStart!=null) ForStatementStart.accept(visitor);
        if(DesignatorStatementFor1!=null) DesignatorStatementFor1.accept(visitor);
        if(ForStatementEnd!=null) ForStatementEnd.accept(visitor);
        if(ForStart!=null) ForStart.accept(visitor);
        if(Matched!=null) Matched.accept(visitor);
        if(ForEnd!=null) ForEnd.accept(visitor);
        if(GetOut!=null) GetOut.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ChangeFor!=null) ChangeFor.traverseTopDown(visitor);
        if(DesignatorStatementFor!=null) DesignatorStatementFor.traverseTopDown(visitor);
        if(ConditionForStart!=null) ConditionForStart.traverseTopDown(visitor);
        if(ConditionFor!=null) ConditionFor.traverseTopDown(visitor);
        if(EndCF!=null) EndCF.traverseTopDown(visitor);
        if(ForStatementStart!=null) ForStatementStart.traverseTopDown(visitor);
        if(DesignatorStatementFor1!=null) DesignatorStatementFor1.traverseTopDown(visitor);
        if(ForStatementEnd!=null) ForStatementEnd.traverseTopDown(visitor);
        if(ForStart!=null) ForStart.traverseTopDown(visitor);
        if(Matched!=null) Matched.traverseTopDown(visitor);
        if(ForEnd!=null) ForEnd.traverseTopDown(visitor);
        if(GetOut!=null) GetOut.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ChangeFor!=null) ChangeFor.traverseBottomUp(visitor);
        if(DesignatorStatementFor!=null) DesignatorStatementFor.traverseBottomUp(visitor);
        if(ConditionForStart!=null) ConditionForStart.traverseBottomUp(visitor);
        if(ConditionFor!=null) ConditionFor.traverseBottomUp(visitor);
        if(EndCF!=null) EndCF.traverseBottomUp(visitor);
        if(ForStatementStart!=null) ForStatementStart.traverseBottomUp(visitor);
        if(DesignatorStatementFor1!=null) DesignatorStatementFor1.traverseBottomUp(visitor);
        if(ForStatementEnd!=null) ForStatementEnd.traverseBottomUp(visitor);
        if(ForStart!=null) ForStart.traverseBottomUp(visitor);
        if(Matched!=null) Matched.traverseBottomUp(visitor);
        if(ForEnd!=null) ForEnd.traverseBottomUp(visitor);
        if(GetOut!=null) GetOut.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("For(\n");

        if(ChangeFor!=null)
            buffer.append(ChangeFor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorStatementFor!=null)
            buffer.append(DesignatorStatementFor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConditionForStart!=null)
            buffer.append(ConditionForStart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConditionFor!=null)
            buffer.append(ConditionFor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(EndCF!=null)
            buffer.append(EndCF.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ForStatementStart!=null)
            buffer.append(ForStatementStart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorStatementFor1!=null)
            buffer.append(DesignatorStatementFor1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ForStatementEnd!=null)
            buffer.append(ForStatementEnd.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ForStart!=null)
            buffer.append(ForStart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Matched!=null)
            buffer.append(Matched.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ForEnd!=null)
            buffer.append(ForEnd.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(GetOut!=null)
            buffer.append(GetOut.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [For]");
        return buffer.toString();
    }
}
