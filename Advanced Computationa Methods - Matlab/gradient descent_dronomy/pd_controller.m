% Compute system inputs and updated state
% Note that input = [?1,. . .,?4]
classdef pd_controller
    properties(SetAccess=public)
        Kd;
        Kp;
    end
    methods
        function r = get.Kd(obj)
            r= obj.Kd ;
        end
        
        
        
        function obj = pd_controller(theta_k1,theta_k2)
            obj.Kd=theta_k1;
            obj.Kp=theta_k2;
        end
        
        function[input, state] = pd_controller_exec(obj,state, thetadot, I, L, b, k,dt)
            global eArr;
            % Controller gains, tuned by hand and intuition.
            %Kd = 4;
            %Kp = 3;
            % Initialize the integral if necessary.
            if ~isfield(state, 'integral')
                params.integral = zeros(3, 1);
                state.integral=params.integral;
                input=[5,5,5,5];
            else
                % Compute total thrust
                if (~isa(state.integral,'double'))
                    state.integral=eval(state.integral);
                end
                total = [state.m].*[state.g]./ [state.k]./(cos(state.integral(1)).*cos(state.integral(2)));
                if (~isa(total,'double'))
                    total=eval(total);
                end
                params.integral=state.integral;
                params.dt=dt;
                % Compute errors
                e = obj.Kd*thetadot + obj.Kp*params.integral;
                eArr = [eArr e];
                % Solve for the inputs,
                %input = error2inputs(params, accels, total);
                accels=[L*k,b];
                [i1,i2,i3,i4] = error2inputs(e, accels, total,I);
                input = [i1,i2,i3,i4];
                % Update the state
                params.integral = params.integral + params.dt.*thetadot;
                state.integral=params.integral;
            end
               
        end
    end
end

