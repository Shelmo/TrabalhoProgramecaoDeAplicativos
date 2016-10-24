function mascara(o, f)
{
    v_obj = o;
    v_fun = f;
    setTimeout("execmascara()", 1);
}

function execmascara()
{
    v_obj.value = v_fun(v_obj.value);
}

function cpf(v)
{
    v = v.replace(/\D/g, "");
    v = v.replace(/(\d{3})(\d)/, "$1.$2");
    v = v.replace(/(\d{3})(\d)/, "$1.$2");

    v = v.replace(/(\d{3})(\d{1,2})$/, "$1-$2");
    return v;
}

function cep(v)
{
    v = v.replace(/\D/g, "");
    v = v.replace(/(\d{2})(\d)/, "$1.$2");
    v = v.replace(/(\d{3})(\d{1,3})$/, "$1-$2");
    return v;
}

function soNumeros(v)
{
    v = v.replace(/\D/g, "");
    return v;
}

function telefone(v)
{
    v = v.replace(/\D/g, "");
    v = v.replace(/^(\d\d)(\d)/g, "($1) $2");
    v = v.replace(/(\d{4})(\d)/, "$1-$2");
    return v;
}

function data(v)
{
    v = v.replace(/\D/g, "");
    v = v.replace(/(\d{2})(\d)/, "$1/$2");
    v = v.replace(/(\d{2})(\d)/, "$1/$2");

    v = v.replace(/(\d{2})(\d{2})$/, "$1$2");
    return v;
}

function moeda(v)
{
    v = v.replace(/\D/g, "");
    v = v.replace(/(\d)(\d{8})$/, "$1.$2");
    v = v.replace(/(\d)(\d{5})$/, "$1.$2");

    v = v.replace(/(\d)(\d{2})$/, "$1,$2");
    return v;
}

function ValidarCPF(Objcpf)
{
    var cpf = Objcpf.value;
    exp = /\.|\-/g;
    cpf = cpf.toString().replace(exp, "");
    var digitoDigitado = eval(cpf.charAt(9) + cpf.charAt(10));
    var soma1 = 0, soma2 = 0;
    var vlr = 11;

    for (i = 0; i < 9; i++)
    {
        soma1 += eval(cpf.charAt(i) * (vlr - 1));
        soma2 += eval(cpf.charAt(i) * vlr);
        vlr--;
    }       
    soma1 = (((soma1 * 10) % 11) === 10 ? 0 : ((soma1 * 10) % 11));
    soma2 = (((soma2 + (2 * soma1)) * 10) % 11);

    var digitoGerado = (soma1 * 10) + soma2;
    if (digitoGerado !== digitoDigitado)        
        alert('CPF Invalido!');         
}

function procurarData(txtFiltro)
{
    var reg = /([0-9]{1,2}\/[0-9]{1,2}\/[0-9]{4})/g;

    var array = "Data Invalida! Utilize o formato dd/MM/aaaa";

    if (reg.test(txtFiltro))
        array = txtFiltro.match(reg);
    else
    {
        document.getElementById('txtFiltro').value = array;
        return;
    }
    var menor;
    var maior;

    menor = array[0];
    maior = array[0];

    for (i = 0; i < array.length; i++)
    {
        if (array[i].substr(6, 10) < menor.substr(6, 10))
        {
            menor = array[i];
        } else
        {
            if (array[i].substr(6, 10) === menor.substr(6, 10))
            {
                if (array[i].substr(3, 5) < menor.substr(3, 5))
                {
                    menor = array[i];
                } else
                {
                    if (array[i].substr(3, 5) === menor.substr(3, 5))
                    {
                        if (array[i].substr(0, 2) < menor.substr(0, 2))
                        {
                            menor = array[i];
                        }
                    }
                }
            }
        }
        if (array[i].substr(6, 10) > maior.substr(6, 10))
        {
            maior = array[i];
        } else
        {
            if (array[i].substr(6, 10) === maior.substr(6, 10))
            {
                if (array[i].substr(3, 5) > maior.substr(3, 5))
                {
                    maior = array[i];
                } else
                {
                    if (array[i].substr(3, 5) === maior.substr(3, 5))
                    {
                        if (array[i].substr(0, 2) > maior.substr(0, 2))
                        {
                            maior = array[i];
                        }
                    }
                }
            }
        }
    }

    var saida;

    if (menor !== maior)
        saida = menor + ' ate ' + maior;
    else
        saida = menor;
    document.getElementById('txtFiltro').value = saida;
}