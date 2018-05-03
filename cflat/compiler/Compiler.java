static final public String ProgramName = "cbc";
static final public String Version = "1.0.0";

static public void main(String[] args) {
    new Compiler(ProgramName).commandMain(args);
}

private final ErrorHandler errorHandler;

public void commandMain(String[] args) {
    Option opts = Option.parse(args);
    List<SourceFile> srcs = opts.soureFiles();
    build(srcs, opts);
}

public void build(List<SourceFile> srcs, Option opts) throws CompileException {
    for (SourceFile src : srcs) {
        compile(src.path(), opts.asmFileNameOf(src), opts);
        assemble(src.path(), opts.objFileNameOf(src), opts);
    }
    link(opts);
}

public void compile(String srcPath, String destPath, Option opts) throws CompileException {
    AST ast = parseFile(srcPath, opts);
    TypeTable types = opts.typeTable();
    AST sem = semanticAnalyze(ast, types, opts);
    IR ir = new IRGenerator(errorHandler).generate(sem, types);
    String asm = generateAssembly(ir, opts);
    writeFile(destPath, asm);
}
