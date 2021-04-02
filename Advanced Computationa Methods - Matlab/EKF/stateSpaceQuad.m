function [ x_dot ] = stateSpaceQuad( L1,L2,L3,L4,input,g,x )
% In:
%   L1,L2,L3,L4,  - Inertia matrices
%   input  - control input
%
% Out:
%
%   dx/dt = first order result state
%
% Description:
%   Creates the state-space model description
%     dx/dt = Ax + Bu + Lw,
%     y = Cx +Mv
zeroMat=zeros(3,3);
onesMat = ones(3,3);
zerosVec=zeros(3,1);

A=[zeroMat,onesMat,zeroMat,zeroMat;zeroMat,zeroMat
    zeroMat,zeroMat;zeroMat,zeroMat,zeroMat,L1;
    zeroMat,zeroMat,zeroMat,L2];

B=[zerosVec,zeroMat;L3,zeroMat;zerosVec,zeroMat;zerosVec,L4];

L=[zerosVec,L5,zerosVec,zerosVec];

x_dot = A*x + B*input - g*L;

end

