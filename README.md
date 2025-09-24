User story:
EU COMO Aluno com assinatura premium, QUERO	Receber 3 moedas a cada curso completo com nota >= 7, PARA Converter em novos cursos ou criptomoedas.

BBD 1:
Dado que o aluno tem assinatura premium, Quando	concluir um curso com média ≥ 7, Então o sistema adiciona 3 moedas na conta do aluno.

BBD 2:
Dado que o aluno premium queira trocar suas moedas por criptomoedas, Quando possui moedas na conta, Então o sistema faz a conversão e entrega as criptomoedas.

BBD3: 
Dado que o aluno possui moedas em sua conta, Quando solicitar a troca por novos cursos, Então o sistema debita as moedas e libera os cursos.

BBD4:
Dado que o aluno premium teve uma média < 7, Quando concluiu um curso, Então o sistema não entrega moedas na conta do aluno.
