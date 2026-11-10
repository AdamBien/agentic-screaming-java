# AGENTS.md

Template for zero-dependency Java 25 CLI applications. The rules live in the skills, not here.

- `/java-cli-app` — project shape, build, code style (composes `/bce`, `/java-conventions`, `/zunit`)
- `/sbce` — one capability spec per business component, spec in `package-info.java`, green tests are the definition of done
- [zb](https://github.com/AdamBien/zb) — build with `zb`, run with `java -jar zbo/app.jar`
- [zunit](https://github.com/AdamBien/zunit) — tests are `*Test.java` scripts in `test/`, each a `void main()` with `assert`; registered as `post.build.hook=zunit` in `.zb`, so every `zb` run compiles, packages, and tests. A red test fails the build.

When cloning the template, set `jar.file.name` in `.zb` to the application's name instead of `app.jar`, and update the run command in `README.md` to match.

Skills are installed from [airails.dev](https://airails.dev).
