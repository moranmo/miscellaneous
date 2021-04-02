function  output_args  = RichardsonTest( input_args )
%Plotting Richardson differences in Logarithmic scale for input vecotr
%n1 = 1:2^8; n2 = 2:2:2^9;
n1 = 1:2^8; n2 = 2:2:2^9;
Dy_1 = input_args(1,n2) - input_args(1,n1); % Richardson differences
Dy_2 = input_args(2,n2) - input_args(2,n1);
Dy_3 = input_args(3,n2) - input_args(3,n1);
X = log10(n1); Y1 = log10(abs(Dy_1));Y2 = log10(abs(Dy_2));Y3 = log10(abs(Dy_3));
plot(X,Y1,'.',X,Y2,'.r',X,Y3,'.y') % Test variables and plot
title('Richardson Test');
xlabel('LOG10n') % x-axis label
ylabel('LOG_10_|Y_2n-Y_n|');
legend('p','q','r');
end

