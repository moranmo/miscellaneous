function [ r ] = ConvRate( input )
%CONVRATE Code that returns the convergance rate of a vector
p=2;
r = abs(diff(input(2:end)) ./ diff(input(1:end - 1)) .^ p);
plot(r)
end

