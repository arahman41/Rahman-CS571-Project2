package src;

// Abstract base class for expressions
abstract class Expr {
    // Part 1: Implement eval() for all non-abstract subclasses
    abstract float eval();

    // Part 2: Implement the visitor pattern
    abstract <R> R accept(ExprVisitor<R> v);
}

// Abstract class for binary expressions (e.g., +, -, *, /)
abstract class BinaryExpr extends Expr {
    private final Expr e1;
    private final Expr e2;

    protected BinaryExpr(Expr e1, Expr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    public Expr getE1() {
        return e1;
    }

    public Expr getE2() {
        return e2;
    }
}

// Concrete classes for binary operations
class PlusExpr extends BinaryExpr {
    public PlusExpr(Expr e1, Expr e2) {
        super(e1, e2);
    }

    @Override
    float eval() {
        return getE1().eval() + getE2().eval();
    }

    @Override
    <R> R accept(ExprVisitor<R> v) {
        return v.visitPlusExpr(this);
    }
}

class MinusExpr extends BinaryExpr {
    public MinusExpr(Expr e1, Expr e2) {
        super(e1, e2);
    }

    @Override
    float eval() {
        return getE1().eval() - getE2().eval();
    }

    @Override
    <R> R accept(ExprVisitor<R> v) {
        return v.visitMinusExpr(this);
    }
}

class TimesExpr extends BinaryExpr {
    public TimesExpr(Expr e1, Expr e2) {
        super(e1, e2);
    }

    @Override
    float eval() {
        return getE1().eval() * getE2().eval();
    }

    @Override
    <R> R accept(ExprVisitor<R> v) {
        return v.visitTimesExpr(this);
    }
}

class DivExpr extends BinaryExpr {
    public DivExpr(Expr e1, Expr e2) {
        super(e1, e2);
    }

    @Override
    float eval() {
        float denominator = getE2().eval();
        if (denominator == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return getE1().eval() / denominator;
    }

    @Override
    <R> R accept(ExprVisitor<R> v) {
        return v.visitDivExpr(this);
    }
}

// Class for floating-point literals
class FloatExpr extends Expr {
    private final float literal;

    public FloatExpr(float f) {
        this.literal = f;
    }

    @Override
    float eval() {
        return literal;
    }

    @Override
    <R> R accept(ExprVisitor<R> v) {
        return v.visitFloatExpr(this);
    }

    public float getLiteral() {
        return literal;
    }
}

