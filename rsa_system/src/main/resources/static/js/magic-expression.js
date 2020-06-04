function magicExpression(str) {
    // 生成字符的表达式的数组
    let charExps = {
        ' ': '([]+{})[!![]+!![]+!![]+!![]+!![]+!![]+!![]]',
        '\\': '([]+/\\\\/)[+!![]]',
        '0': '[]+(+[])',
        '1': '[]+(+!![])',
        '2': '[]+(!![]+!![])',
        '3': '[]+(!![]+!![]+!![])',
        '4': '[]+(!![]+!![]+!![]+!![])',
        '5': '[]+(!![]+!![]+!![]+!![]+!![])',
        '6': '[]+(!![]+!![]+!![]+!![]+!![]+!![])',
        '7': '[]+(!![]+!![]+!![]+!![]+!![]+!![]+!![])',
        '8': '[]+(!![]+!![]+!![]+!![]+!![]+!![]+!![]+!![])',
        '9': '[]+(!![]+!![]+!![]+!![]+!![]+!![]+!![]+!![]+!![])',
        'a': '([]+![])[+!![]]',
        'b': '([]+{})[!![]+!![]]',
        'c': '([]+{})[!![]+!![]+!![]+!![]+!![]]',
        'd': '([]+[][+[]])[!![]+!![]+!![]+!![]+!![]+!![]+!![]+!![]]',
        'e': '([]+!![])[!![]+!![]+!![]]',
        'f': '([]+![])[+[]]',
        'n': '([]+[][+[]])[+!![]]',
        'o': '([]+{})[+!![]]',
        'r': '([]+!![])[+!![]]',
        's': '([]+![])[!![]+!![]+!![]]',
        't': '([]+!![])[+[]]',
        'u': '([]+!![])[!![]+!![]]'
    }
    let charUniCodes = []; // 保存每个字符的 Unicode 符
    
    // 构造 "[]['constructor']['constructor']('return '+'"'+'\\uxxxx'+'"')()" 字符串
    let _constructor = toExp('c') + '+' +
                       toExp('o') + '+' +
                       toExp('n') + '+' +
                       toExp('s') + '+' +
                       toExp('t') + '+' +
                       toExp('r') + '+' +
                       toExp('u') + '+' +
                       toExp('c') + '+' +
                       toExp('t') + '+' +
                       toExp('o') + '+' +
                       toExp('r');
    let _return = toExp('r') + '+' +
                  toExp('e') + '+' +
                  toExp('t') + '+' +
                  toExp('u') + '+' +
                  toExp('r') + '+' +
                  toExp('n') + '+' +
                  toExp(' ');
    let resultHead = '[][' + _constructor + '][' +
                             _constructor + '](' +
                             _return + '+\'"\'+';
    let resultBodys = [];
    let resultFoot = '+\'"\')()';

    // 输入字符串分割为单个字符，转换为 unicode 符后保存
    for (let s of str) {
        let hexCode = s.charCodeAt().toString(16);
        charUniCodes.push(toUnicode(hexCode));
    }

    // 分割保存的每个 Unicode 符为单个字符
    // 并转换为魔法表达式，再拼接保存
    charUniCodes.forEach(x => {
        let exps = []; // 保存每个 Unicode 符的每个字符的魔法表达式
        for (let s of x) {
            exps.push(toExp(s));
        }
        resultBodys.push(exps.join('+'));
    })

    return resultHead + resultBodys.join('+') + resultFoot;
    // return resultBodys[0];

    // hexCode: string
    // 十六进制数字字符转换为正规 Unicode 符格式
    function toUnicode(hexCode) {
        let len = hexCode.length;
        let unicode = '\\u';

        switch (len) {
            case 4:
                break;
            case 3:
                hexCode = '0' + hexCode;
                break;
            case 2:
                hexCode = '00' + hexCode;
                break;
            case 1:
                hexCode = '000' + hexCode;
                break;
        }
        unicode += hexCode;
        return unicode;
    }

    // char: string
    // 单个字符转换为魔法表达式
    function toExp(char) {
        if (charExps[char]) {
            return charExps[char];
        } else {
            return '';
        }
    }
}