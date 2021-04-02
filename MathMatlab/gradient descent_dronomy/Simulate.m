function [DATA  ] = Simulate(con)
global state thetadot I L b k dt x xdot m g kd omega start_time countIter eArr iterCountArr theta;
global thetaArr omegaArr;
thetaArr=[];
omegaArr=[];

countIter=0;
% Initial simulation state.
x = [0; 0; 10];
xdot = zeros(3, 1);
start_time = 0;
end_time = 1;
eArr=[];
iterCountArr=[];
cond =1;
eArrDiff=0;
theta=theta';
times = start_time:dt:end_time;
% Simulate some disturbance in the angular velocity.
% The magnitude of the deviation is in radians / second.
deviation = 100;
thetadot = deg2rad(2*deviation*rand(3, 1) - deviation);
%for t = times
%while min(theta)>tol

while (cond)
    if (~isnan(theta))
        %counting the Iterations
        countIter = countIter+1;
        iterCountArr = [iterCountArr countIter*dt];
        % Take input from our controller.
        [i ,state] = con.pd_controller_exec(state, thetadot, I, L, b, k,dt);
        
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
        if (~isa(a,'double'))
            a=eval(a);
        end
        if (~isa(xdot,'double'))
            xdot=eval(xdot);
        end
        xdot = xdot + dt*a;
        x = x + dt*xdot;
        
        if (~isempty(eArr))
            eArrDiff=abs(eArr(end)-eArr(end-1));
            cond =(eArrDiff)>10;
        end
    end
    
end
theta=theta';
subplot(1,2,1)
DATA.theta=eArr;
DATA.t=iterCountArr;
DATA.dt=dt;

plot(start_time:dt:dt*(size(thetaArr,2)-1),thetaArr)
%iterNum = size(thetaArr,2);
title('Angular Displacement (rad)');
legend('phi','theta','xi');
xlabel('Time(s)') % x-axis label
%subplot(1,2,2)
%plot(start_time:dt:end_time,omegaArr);
%title('Angular Velocities (rad)');
%legend('p','q','r');
%xlabel('Time(s)') % x-axis label
end

