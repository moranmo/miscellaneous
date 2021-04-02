function J = cost(theta)
%Create a controller using the given gains.
control = controller(theta(1), theta(2));
% Perform a simulation.
data = Simulate(control);
% Compute the integral,
t0 = 0;
tf = 1;
J = 1/(tf - t0)*sum(data.theta(data.t >= t0 & data.t <= tf) .^ 2)*data.dt;
end

