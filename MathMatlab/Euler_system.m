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
start_time = 0;
end_time = 4;
global dt;
dt = 0.005;
global eArr;
eArr=[];
times = start_time:dt:end_time;
% Number of points in the simulation.
N = numel(times);
% Initial simulation state.
x = [0; 0; 10];
xdot = zeros(3, 1);
theta = zeros(3, 1);
% Simulate some disturbance in the angular velocity.
% The magnitude of the deviation is in radians / second.
deviation = 100;
thetadot = deg2rad(2*deviation*rand(3, 1) - deviation);
% Step through the simulation, updating the state.
state = struct('t',1,'m',m,'g',g,'k',k);
thetaArr=[];
omegaArr=[];
for t = times
% Take input from our controller.
[i ,state] =  pd_controller(state, thetadot, I, L, b, k,dt);
if (~isa(theta,'double'))
theta=eval(theta);
end
omega = thetadot2omega(thetadot, theta);
if (~isa(omega,'double'))
omega=eval(omega);
end
% Compute linear and angular accelerations.
a = acceleration(i, theta, xdot, m, g, k, kd);
omegadot = angular_acceleration(i, omega, I, L, b, k);
if (~isa(omegadot,'double'))
omegadot=eval(omegadot);
end
omega = omega + dt*omegadot;
omegaArr=[omegaArr omega];

thetadot = omega2thetadot(omega, theta);
theta = theta + dt*thetadot;
thetaArr=[thetaArr theta];

xdot = xdot + dt*a;
x = x + dt*xdot;
% Take input from our controller.
end
subplot(1,2,1)
plot(start_time:dt:end_time,thetaArr)
title('Angular Displacement (rad)');
legend('phi','theta','xi');
xlabel('Time(s)') % x-axis label
subplot(1,2,2)
plot(start_time:dt:end_time,omegaArr);
title('Angular Velocities (rad)');
legend('p','q','r');
xlabel('Time(s)') % x-axis label

figure(2);
RichardsonTest(thetaArr);
RichardsonTest(omegaArr);
AitkenTest(omegaArr);
AitkenTest(thetaArr);
r=ConvRate(thetaArr(1,:));
RichardsonTestForErr(eArr);



