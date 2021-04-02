% Description:
% UPDATE STEP of the EKF :
% In:
%   x_p = State prediction
%   P_p = Covariance matrix update
%
% Out:
%   x   = Updated state
%   p   = Updated covariance
%   K   = Kalman gain

function[x,P, K] = EKF_update(x_p,P_p,sensors,U, Ma_e )

%-----------------------------------
% Jacobian of the sensor equations .
%-----------------------------------
% Accelerometer
J1 = Ma_e* [ 0 r -q ; -r 0 p ; q -p 0 ] ;
J2 = Ma_e* [ 0 -w v ; w 0 -u ; -v u 0 ] ;

H = zeros(6) ;
H( 1 : 3 , 1 : 3 ) = J1 ;
H( 1 : 3 , 4 : 6 ) = 0 ;
H( 4 : 6 , 4 : 6 ) = J2 ;
H( 4 : 6 , 1 : 3 ) = 0 ;

%-------------
% State update
%-------------

% Measurement residual
y_res = sensors -  ya ;

% Innovation covariance
S = H*P_p*H' ;

% Kalman gain
K = P_p*H'/S ;
% Updated state estimate
x = x_p + K*y_res ;

% Updated estimated covariance
P = ( eye (10) - H*K) *P_p;

end

