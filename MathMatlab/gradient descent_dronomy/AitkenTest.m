function  output_args  = AitkenTest( input_args )
%Plotting Richardson differences in Logarithmic scale for input vecotr
n1 = 1:2^9-1; n2=2:2^9;
Dy_1 = log2(input_args(1,n2) - input_args(1,n1)); % Richardson differences
Dy_2 = log2(input_args(2,n2) - input_args(2,n1));
Dy_3 = log2(input_args(3,n2) - input_args(3,n1));
X = n1; Y1 = log2(abs(Dy_1));Y2 = log2(abs(Dy_2));Y3 = log2(abs(Dy_3));
plot(X,Y1,'.',X,Y2,'.r',X,Y3,'.y') % Test variables and plot
hold on
title('Aitken Test');
xlabel('n') % x-axis label
ylabel('LOG_2_|DeltaYn|');
legend('p','q','r');
p = polyfit(X(300:500),Y2(300:500),1);%Linear fitting of the curve
Y2L = polyval(p,X(300:500));
plot(X(300:500),Y2L);
end

