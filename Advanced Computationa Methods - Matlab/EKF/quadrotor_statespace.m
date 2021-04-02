%Physical and environmental parameters
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
global Ir;
Ir=2.029585e-5;
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
end_time = 0.7;
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
xStateArr=[];
xdotArr=[];
thetadotArr=[];
omegadotArr=[];
% Control variables
U1=0 ;
U2=0 ;
U3=0 ;
U4=0 ;
% ------------------------------------------
% Sensor equations
% ------------------------------------------
% Sensor parameters
Ma_e = eye ( 3 ) ;
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
omegadotArr=[omegadotArr omegadot];

thetadot = omega2thetadot(omega, theta);
theta = theta + dt*thetadot;
thetaArr=[thetaArr theta];
thetadotArr=[thetadotArr thetadot];

% Linear velocity components
xdot = xdot + dt*a;
x = x + dt*xdot;
xdotArr=[xdotArr xdot];
% create state space structure 

l1=L1(theta);
l2=L2(I,omega,Ir,i);
l3=L3(theta,m);
l4=L4(I);
l5=[0 0 1];
x_state_vec=[x ;xdot; theta; omega];



Y = zeros(1,N);


% Estimate with EKF
x_state=NonlinearStateSpaceUp( l1,l2,l3,l4,l5,i,g,x_state_vec );
xStateArr   = [xStateArr x_state];
  

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
subplot(3,2,1)
plot(start_time:dt:end_time,xStateArr(3,:),'.',start_time:dt:end_time,xdotArr(3,:),'-')
legend('Filtered estimate','Real signal');
title('Velocity on Z');
xlabel('Time(s)') % x-axis label
ylabel('[m/s]') % x-axis label
subplot(3,2,2)
plot(start_time:dt:end_time,xStateArr(1,:),'.',start_time:dt:end_time,xdotArr(1,:),'-')
legend('Filtered estimate','Real signal');
title('Velocity on X');
xlabel('Time(s)') % x-axis label
ylabel('[m/s]') % x-axis label
subplot(3,2,3)
plot(start_time:dt:end_time,xStateArr(2,:),'.',start_time:dt:end_time,xdotArr(2,:),'-')
legend('Filtered estimate','Real signal');
title('Velocity on Y');
xlabel('Time(s)') % x-axis label
ylabel('[m/s]') % x-axis label
subplot(3,2,4)
plot(start_time:dt:end_time,xStateArr(7,:),'.',start_time:dt:end_time,thetadotArr(1,:),'-')
legend('Filtered estimate','Real signal');
title('Pitch angle');
xlabel('Time(s)') % x-axis label
ylabel('[rad]') % x-axis label
subplot(3,2,5)
plot(start_time:dt:end_time,xStateArr(8,:),'.',start_time:dt:end_time,thetadotArr(2,:),'-')
legend('Filtered estimate','Real signal');
title('Pitch angle');
xlabel('Time(s)') % x-axis label
ylabel('[rad]') % x-axis label
subplot(3,2,6)
plot(start_time:dt:end_time,xStateArr(9,:),'.',start_time:dt:end_time,thetadotArr(3,:),'-')
legend('Filtered estimate','Real signal');
title('Yaw angle');
xlabel('Time(s)') % x-axis label
ylabel('[rad]') % x-axis label

%RichardsonTest(thetaArr);
%RichardsonTest(omegaArr);
%AitkenTest(omegaArr);
%AitkenTest(thetaArr);
%r=ConvRate(thetaArr(1,:));
%RichardsonTestForErr(eArr);

%state space represtation



