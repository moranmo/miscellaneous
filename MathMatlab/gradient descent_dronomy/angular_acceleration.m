function omegadot = angular_acceleration(inputs, omega, I, L, b, k)
if(~all(inputs))
    xxx=1;
end
tau = torques(inputs, L, b, k);
omegadot = inv(I)*(tau - cross(omega, I*omega));

end

