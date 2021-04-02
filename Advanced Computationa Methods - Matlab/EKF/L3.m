function  M  = L3(theta,m)
M=[(sin(theta(3))*sin(theta(2))*cos(theta(1))-cos(theta(3))*sin(theta(1))/m);
    (cos(theta(3))*sin(theta(2))*cos(theta(1))-cos(theta(3))*sin(theta(1))/m);
   cos(theta(1))*cos(theta(1))/m];
end

