function  M  = L1(theta)
M=[1,sin(theta(1))*tan(theta(2)),cos(theta(1)).*tan(theta(2));
    0,cos(theta(1)),-sin(theta(1));
    0,sin(theta(1))/cos(theta(2)),cos(theta(1))/cos(theta(2))];
end

