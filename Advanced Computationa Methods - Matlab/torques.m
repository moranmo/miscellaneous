% Compute torques, given current inputs, length, drag coefficient, and thrust coefficient.%UNTITLED2 Summary of this function goes here
function tau = torques(inputs, L, b, k)
% Inputs are values for
tau = [
    L*k*(inputs(1) - inputs(3))
    L*k*(inputs(2) - inputs(4))
    b*(inputs(1) - inputs(2) + inputs(3) - inputs(4))
    ];
end

