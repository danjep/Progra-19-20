
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
userTree(leaf).
userTree([node(Wert,Kinder)|Rest]) :- userTree(Rest), userTree(Kinder).

