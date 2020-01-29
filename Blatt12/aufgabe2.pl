% a)
userDefinedList(nil).
userDefinedList(cons(X,Y)) :- userDefinedList(Y).


% b)
asPrologList(nil,[]).
asPrologList(cons(X,Y),[Z|A]) :- asPrologList(Y,A).


% c)
flatten([],[]).
flatten([[]|C],D) :- flatten(C,D).
flatten([[A|B]|C],[A|D]) :- flatten([B|C],D).


% d)
tree(node(_, [])).
tree(node(V, [X|XS])) :- tree(X) , tree(node(V, XS)).

/*  node beschreibt einen Knoten im Baum. Dieser hat 2 Attribute: Den zugewiesenen Wert und
    eine Liste aus anderen nodes, welche die Kinder des aktuellen nodes sind.
    Sollte tree also ein node gegeben werden ohne Kinder, so endet der Baum dort, 
    bzw. wird beim nächsten Kind des Elternnodes fortgesetzt.
    Dies wird in der zweiten Zeile festgelegt. 
    Wenn ein node mit mehreren Kindern übergeben wird, fährt das Programm mit dem ersten Kind fort,
    bis dieser Unterbaum durchlaufen ist und macht dann mit den anderen Kindern weiter. 
*/


% e)
flattenTree(X,YS) :- comp(flattenTreet(X),YS).

flattenTreet(node(W,[])) :- W.
flattenTreet(node(W, [Y|YS])) :- append(append(W,fT(Y),Res),fT(node([],YS),Ergebnis)).


comp([],[]).
comp(X,X).

append([],YS,YS).
append(XS,[],XS). 
append([X|XS],YS,[X|ZS]) :- append(XS,YS,ZS).

