def makeid() {
    def text = "";
    String possibleLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String possibleNumbers = "0123456789"
    for (int i = 0; i < 3; i++) {
        text += possibleLetters.charAt(Math.floor(Math.random() * possibleLetters.length()) as Integer);
    }
    for (int i = 0; i < 3; i++) {
        text += possibleNumbers.charAt(Math.floor(Math.random() * possibleNumbers.length()) as Integer);
    }
    return text;
}

def output = new File('output.txt')
if (output.exists()) {
    output.delete()
}

println("Building Code List")
Set<String> codes = []
while (codes.size() < 1000000) {
    def code = makeid()
    codes.add(code)
}

println("Sorting codes")
codes = codes.sort()

println("Writing to file")
output << codes.join("\n")

println("Process Finished")
