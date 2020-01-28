% a)
userDefinedList(nil).
userDefinedList(cons(X,Y)) :- userDefinedList(Y).


% b)
asPrologList(nil,[]).
asPrologList(cons(X,Y),[Z|A]) :- asPrologList(Y,A).


% c)
flatten([[]],[]).
flatten([[A|B]|C],[A|D]) :- flatten([B|C],D).


% d)
tree(node(_, [])).
tree(node(V, [X|XS])) :- tree(X) , tree(node(V, XS)).


% e)
flattenTree(node([],[]),[]).
flattenTree(node([],[Y|YS]),[ZS]) :- flattenTree(Y,ZS).
flattenTree(node([X|XS],[Y|YS],[X|ZS])) :- flattenTree(node(XS,[Y|YS]),ZS).
