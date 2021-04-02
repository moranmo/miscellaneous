% Description:
%   state space representation for the EKF
function  M  = L2(I,omega,Ir,U)
global b;
global L;
%Deriving angular speeds of the propelors
syms omega_f omega_b omega_l omega_r
equ1=b*(omega_f^2 + omega_b^2 + omega_l^2 + omega_r^2)==U(1);
equ2 =b*L*(omega_b^2-omega_r^2)==U(2);
equ3=b*L*(omega_f^2 - omega_b^2)==U(3);
equ4=b*L*(omega_r^2 + omega_l^2 - omega_f^2 - omega_b^2)==U(4);
eqns=[equ1 equ2 equ3 equ4];
omagaArr= solve(eqns,omega_f,omega_b,omega_l,omega_r);
if (~isa(omagaArr.omega_r,'double'))
    omega_r=eval(omagaArr.omega_r);
end
if (~isa(omagaArr.omega_l,'double'))
    omega_l=eval(omagaArr.omega_l);
end
if (~isa(omagaArr.omega_b,'double'))
    omega_b=eval(omagaArr.omega_b);
end
if (~isa(omagaArr.omega_f,'double'))
    omega_f=eval(omagaArr.omega_f);
end
omegaR =omega_r + omega_l - omega_f - omega_b;
%A problem arises if the quantities under the square roots are negative. In that case
%we would have imaginary values of hich obviously have no physical meaning
%thus the desired control is not achievable
if(~isreal(omegaR))
    prodElem = 0;
else
    prodElem=omegaR*Ir/I(1);
end
M=[0,omega(3)*((I(2,2)-I(3,3))/I(1,1))+prodElem,0;omega(3)*((I(3,3)-I(1,1))/I(2,2))-prodElem,0,0;(I(1,1)-I(2,2))/I(3,3),0,0];
end

