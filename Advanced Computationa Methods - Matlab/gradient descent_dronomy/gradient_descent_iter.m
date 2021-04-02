%Mechanical Properties for the Drone
%Propelor length
global L   ;
L=5.0;
%Drag Coefficient
global b;
b=1.3;
%Thrust Ratio
global k;
k=1.9 ;
%Inertia moments
global I;
I=diag([0.002237568,0.002985236,0.00480374]);
%Mass of drone
global m;
m=0.429;
%Gravitiy coefficient
global g;
g=9.81;
%Friction coefficients - Drag forces
global kd;
kd=[-0.5 -0.5 -0.5];
% Simulation times, in seconds.
global start_time;
start_time = 0;
global end_time;
end_time = 1;
global dt;
dt = 0.005;
global eArr;
eArr=[];
global iterCountArr;
iterCountArr=[];
times = start_time:dt:end_time;
% Number of points in the simulation.
N = numel(times);
% Initial simulation state.
global x;
x = [0; 0; 10];
global xdot;
xdot = zeros(3, 1);
global theta;
theta = [3 ,3 ,3];
% Step through the simulation, updating the state.
global state;
state = struct('t',1,'m',m,'g',g,'k',k);
% Compute derivative with respect to first parameter.
delta = 0.01;%Iterator step size
costArr=[];
iterArr=[];
for iter=1:5
var = [1, 0, 0];
currTheta = theta;
derivativeArgP=cost(currTheta + delta*var);

derivativeArgM=cost(currTheta - delta*var);
derivative = (derivativeArgP - derivativeArgM) / (2*delta);
theta=theta-derivative;
costArr=[costArr cost(currTheta)];
%iterArr=[iterArr size(iterCountArr)];
end