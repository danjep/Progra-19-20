/**
 * Ein Objekt der Klasse BoolTreeNode repraesentiert einen booleschen
 * Binaerbaum. Dieser Baum steht fuer eine boolesche Formel ueber Variablen,
 * true und false.
 */
public class BoolTreeNode {
    private String variable;
    private BoolTreeNode child1;
    private BoolTreeNode child2;

    /**
     * Konstruktor fuer einen neuen booleschen Binaerbaum, der eine Variable
     * repraesentiert.
     * 
     * @param variableInput die nicht negative Hoehe
     */
    private BoolTreeNode(String variableInput) {
        variable = variableInput;
        child1 = null;
        child2 = null;
    }

    /**
     * Konstruktor fuer einen neuen booleschen Binaerbaum, der die Negation der
     * Repraesentation des uebergebenen Baums repraesentiert.
     * 
     * @param negated der zu negierende Binaerbaum
     */
    private BoolTreeNode(BoolTreeNode negated) {
        variable = "";
        child1 = negated;
        child2 = null;
    }

    /**
     * Konstruktor fuer einen neuen booleschen Binaerbaum, der die Konjunktion der
     * Repraesentationen der uebergebenen Baeume repraesentiert.
     * 
     * @param conjunct1 der erste zu konjugierende Binaerbaum
     * @param conjunct2 der zweite zu konjugierende Binaerbaum
     */
    private BoolTreeNode(BoolTreeNode conjunct1, BoolTreeNode conjunct2) {
        variable = "";
        child1 = conjunct1;
        child2 = conjunct2;
    }

    /**
     * Erzeugt einen neuen booleschen Binaerbaum, der true repraesentiert.
     * 
     * @return den neuen booleschen Binaerbaum, der true repraesentiert
     */
    public static BoolTreeNode boolTreeTrueNode() {
        BoolTreeNode res = new BoolTreeNode("true");
        return res;
    }

    /**
     * Erzeugt einen neuen booleschen Binaerbaum, der false repraesentiert.
     * 
     * @return den neuen booleschen Binaerbaum, der false repraesentiert
     */
    public static BoolTreeNode boolTreeFalseNode() {
        BoolTreeNode res = new BoolTreeNode("false");
        return res;
    }

    /**
     * Erzeugt einen neuen booleschen Binaerbaum, der eine Variable repraesentiert.
     * 
     * @param variableInput die zu repraesentierende Variable
     * @return den neuen booleschen Binaerbaum, der die Variable repraesentiert
     */
    public static BoolTreeNode boolTreeVariableNode(String variableInput) {
        if (variableInput.equals("true") || variableInput.equals("false")) {
            Utils.error("Variable must not be namend \"true\" or \"false\"");
            return null;
        } else if (variableInput.equals("")) {
            Utils.error("Variable must not have empty string as name");
            return null;
        } else {
            BoolTreeNode res = new BoolTreeNode(variableInput);
            return res;
        }
    }

    /**
     * Erzeugt einen neuen booleschen Binaerbaum, der eine Negation repraesentiert.
     * 
     * @param negated der Binaerbaum der zu negierenden Formel
     * @return den neuen booleschen Binaerbaum, der die Negation repraesentiert
     */
    public static BoolTreeNode boolTreeNotNode(BoolTreeNode negated) {
        if (negated == null) {
            Utils.error("Negation-child is null, new node cannot be created");
            return null;
        }
        BoolTreeNode notnode = new BoolTreeNode(negated);
        return notnode;
    }

    /**
     * Erzeugt einen neuen booleschen Binaerbaum, der eine Konjunktion
     * repraesentiert.
     * 
     * @param conjunct1 der Binaerbaum der ersten zu konjugierenden Formel
     * @param conjunct2 der Binaerbaum der zweiten zu konjugierenden Formel
     * @return den neuen booleschen Binaerbaum, der die Konjunktion repraesentiert
     */
    public static BoolTreeNode boolTreeAndNode(BoolTreeNode conjunct1, BoolTreeNode conjunct2) {
        if (conjunct1 == null || conjunct2 == null) {
            if (conjunct1 != null || conjunct2 != null) {
                Utils.error("One of the conjunction-children is null, new node cannot be created");
                return null;
            } else {
                Utils.error("Both conjunction-children are null, new node cannot be created");
                return null;
            }
        }
        BoolTreeNode andnode = new BoolTreeNode(conjunct1, conjunct2);
        return andnode;
    }

    /**
     * public, weil sonnst kein Zugriff von außerhalb der Klasse möglich
     * 
     * static, weil die Methode nicht logisch an eine Instanz eines Knoten gebunden
     * ist, da sie ja einen neuen Knoten erzeugt.
     * 
     * a v b = n(n(a v b)) = n(n(a) ^ n(b))
     * 
     * @param disjunct1 der Binaerbaum der ersten zu disjugierenden Formel
     * @param disjunct2 der Binaerbaum der zweiten zu disjugierenden Formel
     * @return den neuen booleschen Binaerbaum, der die Disjunktion repraesentiert
     * 
     */
    public static BoolTreeNode boolTreeOrNode(BoolTreeNode disjunct1, BoolTreeNode disjunct2) {
        if (disjunct1 == null || disjunct2 == null) {
            if (disjunct1 != null || disjunct2 != null) {
                Utils.error("One of the disjunction-children is null, new node cannot be created");
                return null;
            } else {
                Utils.error("Both disjunction-children are null, new node cannot be created");
                return null;
            }
        }
        BoolTreeNode ornode = boolTreeNotNode(boolTreeAndNode(boolTreeNotNode(disjunct1), boolTreeNotNode(disjunct2)));
        return ornode;
    }

    /**
     * Ermittelt die Tiefe des booleschen Binaerbaums.
     * 
     * @return die Tiefe des booleschen Binaerbaums
     */
    public int depth() {
        if (child1 != null) {
            int depth1 = child1.depth();
            if (child2 != null) {
                int depth2 = child2.depth();
                return Utils.max(depth1, depth2) + 1;
            } else {
                return depth1 + 1;
            }
        } else {
            return 0;
        }
    }

    /**
     * Ermittelt, ob der boolesche Binaerbaum ein Blatt ist, also keine Kinder hat.
     * 
     * @return true, wenn der Baum ein Blatt ist, sonst false
     */
    public boolean isLeaf() {
        return (child1 == null && child2 == null);
    }

    /**
     * Ermittelt, ob der boolesche Binaerbaum ein Blatt ist, das true
     * repraesentiert.
     * 
     * @return true, wenn der Baum ein Blatt ist und true repraesentiert, sonst
     *         false
     */
    public boolean isTrueLeaf() {
        return (isLeaf() && variable.equals("true"));
    }

    /**
     * Ermittelt, ob der boolesche Binaerbaum ein Blatt ist, das false
     * repraesentiert.
     * 
     * @return true, wenn der Baum ein Blatt ist und false repraesentiert, sonst
     *         false
     */
    public boolean isFalseLeaf() {
        return (isLeaf() && variable.equals("false"));
    }

    /**
     * Ermittelt, ob der boolesche Binaerbaum eine Negation repraesentiert.
     * 
     * @return true, wenn der Baum eine Negation repraesentiert, sonst false
     */
    public boolean isNegation() {
        return (child1 != null && child2 == null);
    }

    /**
     * Ermittelt, ob der boolesche Binaerbaum eine Konjunktion repraesentiert.
     * 
     * @return true, wenn der Baum eine Konjunktion repraesentiert, sonst false
     */
    public boolean isConjunction() {
        return (child1 != null && child2 != null);
    }

    /**
     * Ermittelt den Wahrheitswert der durch den booleschen Binaerbaum bei einer
     * gegebenen Variablenbelegung.
     * 
     * @param trueVars genau die Variablen, die zu true evaluiert werden
     * @return true, die repraesentierte Formel zu true evaluiert wird, sonst false
     */
    public boolean evaluate(String... trueVars) {
        if (child1 == null && child2 == null) {
            return Utils.evaluateVariable(variable, trueVars);
        } else if (child1 != null && child2 == null) {
            return !(child1.evaluate(trueVars));
        } else if (child1 != null && child2 != null) {
            return child1.evaluate(trueVars) && child2.evaluate(trueVars);
        } else {
            Utils.error("Should never occur");
            return false;
        }
    }

    /**
     * Baum als Text.
     * 
     * @return Den Baum ab diesem Knoten als String formatiert
     */
    public String toString() {
        return toStringRec(this);
    }

    private String toStringRec(BoolTreeNode node) {
        if (node.isNegation()) {
            return "not(" + node.child1 + ")";
        } else if (node.isConjunction()) {
            return "(" + node.child1 + " and " + node.child2 + ")";
        } else {
            return node.variable;
        }
    }

    /**
     * Entfernt alle Vorkommen von doppelten Negationen aus dem gesamten Baum.
     * 
     * @return true, wenn irgendwo eine Veraenderung vorgenommen wurde, sonst false
     */
    public boolean removeDoubleNegations() {
        if (isNegation()) {
            if (child1.isNegation()) {
                child1.child1.removeDoubleNegations();
                child2 = child1.child1.child2;
                variable = child1.child1.variable;
                child1 = child1.child1.child1;
                return true;
            } else {
                return child1.removeDoubleNegations();
            }
        }
        if (isConjunction()) {
            return child1.removeDoubleNegations() | child2.removeDoubleNegations();
        }
        return false;
    }

    /**
     * Ersetzt alle Vorkommen von Negationen mit anschließendem true oder false aus
     * dem gesamten Baum mit dem entsprechenden Gegenstück.
     * 
     * @return true, wenn irgendwo eine Veraenderung vorgenommen wurde, sonst false
     */
    public boolean removeAtomicNegations() {
        if (isNegation()) {
            if (child1.isTrueLeaf()) {
                variable = "false";
                child1 = null;
                return true;
            } else if (child1.isFalseLeaf()) {
                variable = "true";
                child1 = null;
                return true;
            } else {
                return child1.removeAtomicNegations();
            }
        }
        if (isConjunction()) {
            return child1.removeAtomicNegations() | child2.removeAtomicNegations();
        }
        return false;
    }

    /**
     * Ersetzt alle Vorkommen von Konjugationen mit doppelter Verwendung von x aus
     * dem gesamten Baum mit x.
     * 
     * @return true, wenn irgendwo eine Veraenderung vorgenommen wurde, sonst false
     */
    public boolean removeIdempotency() {
        if (isConjunction()) {
            if (child1.isLeaf() && child2.isLeaf()) {
                if (child1.variable.equals("x") && child2.variable.equals("x")) {
                    variable = "x";
                    child1 = null;
                    child2 = null;
                    return true;
                } else {
                    return false;
                }
            } else {
                return child1.removeIdempotency() | child2.removeIdempotency();
            }
        } else if (isNegation()) {
            return child1.removeIdempotency();
        } else {
            return false;
        }
    }

    /**
     * Ersetzt alle Vorkommen von Konjugationen mit Verwendung von x und nicht x aus
     * dem gesamten Baum mit false.
     * 
     * @return true, wenn irgendwo eine Veraenderung vorgenommen wurde, sonst false
     */
    public boolean findBasicContradictions() {
        if (isConjunction()) {
            if ((child1.isNegation() && child1.child1.variable.equals("x") && child2.variable.equals("x"))
                    || (child2.isNegation() && child2.child1.variable.equals("x") && child1.variable.equals("x"))) {
                variable = "false";
                child1 = null;
                child2 = null;
                return true;
            } else {
                return child1.findBasicContradictions() | child2.findBasicContradictions();
            }
        } else if (isNegation()) {
            return child1.findBasicContradictions();
        } else {
            return false;
        }
    }

    /**
     * Ersetzt alle Vorkommen von Konjugationen mit Verwendung von true aus dem
     * gesamten Baum mit der anderen Konjugation.
     * 
     * @return true, wenn irgendwo eine Veraenderung vorgenommen wurde, sonst false
     */
    public boolean removeTrueConjuncts() {
        if (isConjunction()) {
            if (child1.isTrueLeaf()) {
                variable = child2.variable;
                child1 = child2.child1;
                child2 = child2.child2;
                return true;
            } else if (child2.isTrueLeaf()) {
                variable = child1.variable;
                child2 = child1.child2;
                child1 = child1.child1;
                return true;
            } else {
                return child1.removeTrueConjuncts() | child2.removeTrueConjuncts();
            }
        } else if (isNegation()) {
            return child1.removeTrueConjuncts();
        } else {
            return false;
        }
    }

    /**
     * Ersetzt alle Vorkommen von Konjugationen mit Verwendung von false aus dem
     * gesamten Baum mit false.
     * 
     * @return true, wenn irgendwo eine Veraenderung vorgenommen wurde, sonst false
     */
    public boolean findFalseConjuncts() {
        if (isConjunction()) {
            if (child1.isFalseLeaf() || child2.isFalseLeaf()) {
                variable = "false";
                child1 = null;
                child2 = null;
                return true;
            } else {
                return child1.findFalseConjuncts() | child2.findFalseConjuncts();
            }
        } else if (isNegation()) {
            return child1.findFalseConjuncts();
        } else {
            return false;
        }
    }

    /**
     * Verkleinert den Baum solange bis er minimal ist.
     */
    public void reduce() {
        boolean changed = false;
        do {
            if (removeDoubleNegations() || removeAtomicNegations() || removeIdempotency() || findBasicContradictions()
                    || removeTrueConjuncts() || findFalseConjuncts()) {
                changed = true;
            } else {
                changed = false;
            }
        } while (changed);
    }

}
