function  output_args  = AitkenTest( input_args )
%Plotting Richardson differences in Logarithmic scale for input vecotr
n1 = 1:2^8-1; n2=2:2^8;
Dy_1 = log2(input_args(1,n2) - input_args(1,n1)); % Richardson differences
Dy_2 = log2(input_args(2,n2) - input_args(2,n1));
Dy_3 = log2(input_args(3,n2) - input_args(3,n1));
X = n1; Y1 = log10(abs(Dy_1));Y2 = log10(abs(Dy_2));Y3 = log10(abs(Dy_3));
plot(X,Y1,'.',X,Y2,'.r',X,Y3,'.y') % Test variables and plot
title('Aitken Test');
xlabel('n') % x-axis label
ylabel('LOG_2_|DeltaYn|');
legend('phi','teta','xi');
end

