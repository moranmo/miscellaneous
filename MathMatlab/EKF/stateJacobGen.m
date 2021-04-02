function [ x_dot ] = stateJacobGen( L1,L2,L3,L4,L5,u,g,x )
% In:
%   L1,L2,L3,L4,  - Inertia matrices
%
%   u(control input) = [T tau_phi tau_theta tau_psi]
%
% Out:
%
%   dx/dt = first order result state
%
% Description:
%   Creates the state-space model description
%       dx/dt = Ax + Bu + Lw,
%       y = Cx +Mv
%     while,
%       x = [x y z vx vy vz f q y p q r]'
zeroMat=zeros(3,3);
onesMat = ones(3,3);
zerosVec=zeros(3,1);

A=[[zeroMat,onesMat,zeroMat,zeroMat];[zeroMat,zeroMat,zeroMat,zeroMat];[zeroMat,zeroMat,zeroMat,L1];
    [zeroMat,zeroMat,zeroMat,L2]];

B=[[zerosVec,zeroMat];[L3,zeroMat];[zerosVec,zeroMat];[zerosVec,L4]];

L=[zerosVec;L5';zerosVec;zerosVec];

x_dot = A*x + B*u' - g*L;

end

