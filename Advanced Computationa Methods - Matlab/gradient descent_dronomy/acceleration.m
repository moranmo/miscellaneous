function a = acceleration(inputs, angles, xdot, m, g, k, kd)
gravity = [0; 0; -g];
if (~isa(angles(1),'double'))
angles=eval(angles);
end
if (~isa(inputs,'double'))
inputs=eval(inputs);
end
R = rotation(angles);
T = R*thrust(inputs, k);
Fd = -kd*xdot;
a = gravity + 1 / m*T + Fd;
end

