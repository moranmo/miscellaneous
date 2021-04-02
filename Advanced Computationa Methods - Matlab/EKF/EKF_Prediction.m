% Description:
% 	PREDICTION STEP o f the discrete time EKF
% In:
%   F_old - Partial derivatives of the state equations .
%   omega - Angular velocity
%   x     - linear position
%   U     - control input
%
% Out:
%   x_p = State prediction
%   P_p = Covariance matrix update
function [x_p,P_p] = EKF_Prediction(omega_old,x_old,F_old,Q_e,U)
global dt;
global m;
% Linear velocity components
u_old = x_old ( 1 ) ;
v_old = x_old ( 2 ) ;
w_old = x_old ( 3 ) ;
%Angular velocity components
p_old = omega_old(1) ;
q_old = omega_old(2) ;
r_old = omega_old(3) ;
% Note : the statevariables psi_old and z_old are not required

% State prediction
x_p=[r_old *v_old - q_old*w_old;p_old*w_old - r_old *u_old;q_old*u_old -p_old*v_old+U(1)/m];


F_old = dt*F_old ;
% Covariance prediction
P_p = F_old*P_old*F_old' + Q_e;












