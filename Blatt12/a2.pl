% a)
userDefinedList(nil).
userDefinedList(cons(_,Y)) :- userDefinedList(Y).


% b)
asPrologList(nil, []).
asPrologList(cons(X,Y), [X|Z]) :- asPrologList(Y,Z).

% c)
flatten([],[]).
flatten([[]|XS], YS) :- flatten(XS,YS).
flatten([[A|AS]|XS],[A|YS]) :- flatten([AS|XS],YS).

% d)
tree(node(_, [])).
tree(node(V, [X|XS])) :- tree(X) , tree(node(V, XS)).