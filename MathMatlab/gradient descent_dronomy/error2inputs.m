%Compute inputs vector to the plant givent error vector
function [ i1, i2, i3,  i4 ] = error2inputs( e,accels,total,I )
syms g1 g2 g3 g4;
if (~isa(e,'double'))
e=eval(e);
end
eqn1= accels(1)*(g1-g3)==-I(1,1)*(e(1));
eqn2=accels(1)*(g2-g4)==-I(2,2)*(e(2));
eqn3= accels(2)*(g1-g2+g3-g4)==-I(3,3)*(e(3));
eqn4=(g1+g2+g3+g4)==total;
eqns=[eqn1,eqn2,eqn3,eqn4];
[i1, i2, i3 , i4]=solve(eqns,g1,g2,g3,g4);
end

