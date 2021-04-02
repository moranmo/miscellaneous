function  omega  = thetadot2omega(thetadot,theta )
M1=[1,0,0;0,cos(theta(1)),sin(theta(1));0,-sin(theta(1)),cos(theta(1))];
M2=[cos(theta(2)),0,-sin(theta(2));0,1,0;sin(theta(2)),0,cos(theta(2))];
if (~isa(M1,'double'))
M1=eval(M1);
M2=eval(M2);
end
omega= ([thetadot(1),0,0]' + M1*[0;thetadot(2);0]+M1*M2*[0;thetadot(3);0]);
end

