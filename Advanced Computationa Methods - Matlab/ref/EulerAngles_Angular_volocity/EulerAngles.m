%% Euler Angles 
% The direction cosine matrix of an orthogonal transformation from XYZ to 
% xyz is Q. Find the Euler angles fi , theta and psi for this transformation.
clc;
clear all;
% Direction cosine matrix
Q = [-0.32175 0.89930 -0.29620;
    0.57791 -0.061275 -0.81380;
    -0.7500 -0.43301, -0.5000];
fi = atan2d(Q(3,1),-Q(3,2)); % Precession angle [0..360]
fprintf('Precession angle   fi    = %4.2f [deg]\n',fi); 
theta = acosd(Q(3,3));        % Nutation angle [0..180]
fprintf('Precession angle   theta = %4.2f [deg]\n',theta); 
psi = atan2d(Q(1,3),Q(2,3)); % Spin angle [0..360]
fprintf('Precession angle   fi    = %4.2f [deg]\n\n',psi); 
%%
%% 
% At a given instant, the unit vectors of a body frame are
i = [ 0.40825 -0.40825   0.81649];  % IJK inertial frame 
j = [-0.10102 -0.90914  -0.40405];
k = [ 0.90726  0.082479 -0.41240];
% The angular velocity is
wX = [-3.1; 2.5; 1.7];                 % [rad/s] IJK inertial frame 
% Calculate wp , wn and ws (the precession, nutation and spin rates) at
% this instant.
QXx = [i;j;k];
wx = QXx*wX; 
w_x = wx(1);w_y = wx(2);w_z = wx(3);
% The components of the angular velocity in the body frame are
fprintf('wx = %4.4f[rad/s]  wy = %4.4f[rad/s]  wz = %4.4f[rad/s] \n\n',...
    wx(1),wx(2),wx(3));
% Calculating the Euler angles fi,theta and psi from direction cosine matrix.
fi = atan2d(QXx(3,1),-QXx(3,2)); % Precession angle [0..360]
fprintf('Precession angle   fi    = %4.2f [deg]\n',fi); 
theta = acosd(QXx(3,3));        % Nutation angle [0..180]
fprintf('Precession angle   theta = %4.2f [deg]\n',theta); 
psi = atan2d(QXx(1,3),QXx(2,3)); % Spin angle [0..360]
fprintf('Precession angle   fi    = %4.2f [deg]\n\n',psi); 
% Now we can obtain Euler angle rates from the angular velocitis wx,wy,wz
wp = 1/sind(theta)*(w_x*sind(psi) + w_x*cosd(psi));
wn = w_x*cosd(psi) - w_y*sind(psi);
ws = -1/tand(theta)*(w_x*sind(psi) + w_y*cosd(psi)) + w_z;
fprintf('wp = %4.4f[rad/s]  wn = %4.4f[rad/s]  ws = %4.4f[rad/s] \n\n',...
    wp,wn,ws);
%%
%% 
% The mass moments of inertia of a body about the principal body frame 
% axes with origin at the center of mass G are
A = 1000;           % [kg*m^2]
B = 2000;           % [kg*m^2]
C = 3000;           % [kg*m^2]
% The Euler angles in radians are given as functions of time in seconds 
% as follows:
dt = 0.01;
t = 0:dt:(10+2*dt);
fi    = rem(2*t.*exp(-0.05*t),2*pi);
theta = rem(0.02 + 0.3*sin(0.25*t),2*pi);
psi   = rem(0.6*t,2*pi);
% Compute derivatives for Euler angles
wp = diff(fi)/dt;      % d(fi)/d(t)
wn = diff(theta)/dt;   % d(theta)/d(t)
ws = diff(psi)/dt;     % d(psi)/d(t)

dwp = diff(wp)/dt;     % d(wp)/d(t)
dwn = diff(wn)/dt;     % d(wn)/d(t)
dws = diff(ws)/dt;     % d(ws)/d(t)
% Evaluating all of these quantities  at t =10 [s] yields
n = size(t);
fprintf('fi = %4.2f [deg]       wp = %6.5f [rad/s]     dwp = %6.5f [rad/s^2]\n',...
    fi(n(2)-2)*180/pi,wp(n(2)-2),dwp(n(2)-2));
fprintf('theta = %4.2f [deg]     wn = %6.5f [rad/s]     dwn = %6.5f [rad/s^2]\n',...
    theta(n(2)-2)*180/pi,wn(n(2)-2),dwn(n(2)-2));
fprintf('psi = %4.2f [deg]       ws = %6.5f [rad/s]     dws = %6.5f [rad/s^2]\n\n',...
    psi(n(2)-2)*180/pi,ws(n(2)-2),dws(n(2)-2));
%%
%%
% At t = 10 [s], find the net moment about G 
% Calculating angular velocity components using the Euler angle rates
% at t = 10 
fi    =  fi(n(2)-2)*180/pi;     wp = wp(n(2)-2);    dwp = dwp(n(2)-2);
theta =  theta(n(2)-2)*180/pi;  wn = wn(n(2)-2);    dwn = dwn(n(2)-2);
psi   =  psi(n(2)-2)*180/pi;    ws = ws(n(2)-2);    dws = dws(n(2)-2);
% Angular velocity components in body fixed xyx frame
wx = wp*sind(theta)*sind(psi) + wn*cosd(psi);
wy = wp*sind(theta)*cosd(psi) - wn*sind(psi);
wz = ws + wp*cosd(theta);
% Taking the time derivative of each of these equations we will obtain
% angular acceleration of the space craft in the body fixed frame
dwx = wp*wn*cosd(theta)*sind(psi) + wp*ws*sind(theta)*cosd(psi)-...
    wn*ws*sind(psi) + dwp*sind(theta)*sind(psi) + dwn*cosd(psi);
dwy = wp*wn*cosd(theta)*cosd(psi) - wp*ws*sind(theta)*sind(psi)-...
    wn*ws*cosd(psi) + dwp*sind(theta)*cosd(psi) - dwn*sind(psi);
dwz = -wp*wn*sind(theta) + dwp*cosd(theta) + dws; 
fprintf('wx = %6.5f  [rad/s]     wy = %6.5f [rad/s]      wz = %6.5f  [rad/s]\n',...
    wx,wy,wz);
fprintf('dwx = %6.5f [rad/s^2]   dwy = %6.5d  [rad/s^2]     dwz = %6.5f [rad/s^2]\n\n',...
    dwx,dwy,dwz);
%%
%% Euler’s equations
Mx_net  = A*dwx + (C - B)*wy*wz;
My_net  = B*dwy + (A - C)*wx*wz;
Mz_net  = C*dwz + (B - A)*wx*wy;
fprintf('Mx_net = %4.2f [N*m], My_net = %4.2f [N*m], Mz_net = %4.2f [N*m]\n\n',...
    Mx_net,My_net,Mz_net);
% Now we will project the components of relative acceleration onto the 
% axes of the inertial frame.
% Required orthogonal transformation matrix 
QxX = [-sind(fi)*cosd(theta)*sind(psi) + cosd(fi)*cosd(psi), ...
 -sind(fi)*cosd(theta)*cosd(psi) - cosd(fi)*sind(psi),sind(fi)*sind(theta);
 cosd(fi)*cosd(theta)*sind(psi) + sind(fi)*cosd(psi),...
  cosd(fi)*cosd(theta)*cosd(psi) - sind(fi)*sind(psi),-cosd(fi)*sind(theta);
    sind(theta)*sind(psi),   sind(theta)*cosd(psi),    cosd(theta) 
       ]
% Angular velocity rates in inertial frame; 
% Transition from Body Fiexed to Inertial Frame  
w_xyz = [dwx;dwy;dwz]; 
w_XYZ = QxX*w_xyz;
fprintf('w_xyz = [ %6.5f  %6.5f  %6.5f ] rad/s^2\n',w_xyz);
fprintf('w_XYZ = [ %6.5f  %6.5f  %6.5f ] rad/s^2\n\n',w_XYZ);
% To check our results
% Transition from Inertial Frame to Body Fiexed
w_xyz = QxX'*w_XYZ;
fprintf('w_XYZ = [ %6.5f  %6.5f  %6.5f ] rad/s^2\n',w_XYZ);
fprintf('w_xyz = [ %6.5f  %6.5f  %6.5f ] rad/s^2\n\n',w_xyz);
% We get the desired values.
%%
%% Yaw, Pitch and Roll Angles 
% For the given direction cosine matrix obtain YAW, PITCH AND ROLL ANGLES
QXx =[-0.32175   0.89930   -0.29620; 
       0.57791  -0.061275  -0.81380;
      -0.75     -0.43301   -0.5  ];
 yaw   = atan2d(QXx(1,2),QXx(1,1));
 pitch = asin(-QXx(1,3))*180/pi; 
 roll  = atan2d(QXx(2,3),QXx(3,3));
 fprintf('Yaw = %6.5f [deg]  Pitch = %6.5f [deg]   Roll = %6.5f [deg]\n'...
     ,yaw,pitch,roll);
 % Now lets optain direction cosine matrix from Yaw,Pitch and Roll angles
 R1_roll  =  [1            0           0; 
             0            cosd(roll)  sind(roll);
             0           -sind(roll)  cosd(roll);
             ]
 R2_pitch = [cosd(pitch)  0     -sind(pitch); 
             0            1       0;
             sind(pitch)  0      cosd(pitch)]
       
 R3_yaw   =   [ cosd(yaw)   sind(yaw)   0; 
             -sind(yaw)   cosd(yaw)   0;
             0            0          1]
 QXx      = R1_roll*R2_pitch*R3_yaw
%%

 